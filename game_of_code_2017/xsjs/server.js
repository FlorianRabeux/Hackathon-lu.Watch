var express = require('express')
var app = express()
var xsenv = require('sap-xsenv')
var services = xsenv.getServices({ hana:'lu.watch-hdi-container' })
var hdbext = require('sap-hdbext')
var cds = require('sap-cds')
var client = null
var oUserEntity = null 

// Prepare entities 
cds.$importEntities([{
	$entity: "be.nrb::LuWatch.User"
}], function(error, entities){
	oUserEntity = entities["be.nrb::LuWatch.User"]
})

// Set db connection middleware for all incoming requests
app.use('/', hdbext.middleware(services.hana))

// Prepare POST Parameters
var bodyParser = require('body-parser')
app.use(bodyParser.json()) // support json encoded bodies
app.use(bodyParser.urlencoded({ extended: true })) // support encoded bodies


// GET /users
app.get('/users', function(req, res){
	cds.$getTransaction(req.db, function(error, tx){
		if (error){
			res.type("text/plain").status(500).send(`Error: ${error.toString()}`)
			return;
		}
		client = tx;
		client.$find(oUserEntity, {},  function(error, instances){
			if (error){
				res.type("text/plain").status(500).send(`Error: ${error.toString()}`)
				return;
			}
			res.type("application/json").status(200).send(JSON.stringify(instances))
			client.$close()
		})
	})
})

// GET /user
app.get('/user', function(req, res){
	cds.$getTransaction(req.db, function(error, tx){
		if (error){
			res.type("text/plain").status(500).send(`Error: ${error.toString()}`)
			return;
		}
		client = tx;
		client.$get(oUserEntity, {id:1}, function(error, instance){
			if (error){
				res.type("text/plain").status(500).send(`Error: ${error.toString()}`)
				return;
			}
			res.type("application/json").status(200).send(JSON.stringify(instance))
			client.$close()
		})
	})
})

// POST User
app.post('/user', function(req, res){
	cds.$getTransaction(req.db, function(error, tx){
		client = tx
		// var newUser = {
		// 	id: 1, 
		// 	name: "name",
		// 	password: "123"
		// }
		// client.$save(oUserEntity.$prepare(newUser), function(error){
		// 	if (error) {
		// 		res.type("text/plain").status(500).send(`Error: ${error.toString()}`)
		// 		return
		// 	}
		// })
		// res.type("application/json").status(200).send(`User created`)
		var name = req.body.name
		var pass = req.body.password
		// var newUserID = nextID(client, "be.nrb::userID")
		var newUserID = 0

		client.prepare(
			`select \"be.nrb::userID\".nextval from DUMMY`,
			function(err, statement) {
				if (err) {
					res.type("text/plain").status(500).send("ERROR: " + err.toString());
					return;
				}
				statement.exec([],
					function(err, results) {
						if (err) {
							res.type("text/plain").status(500).send("ERROR: " + err.toString());
						} else {
							var result = JSON.stringify({
								Objects: results
							});
							newUserID = result['Objects']
							res.send(`PARAMS = ${name} : ${pass} -> ${newUserID} - ${result}`)
						}
				})
			})


		//  res.type("application/json").status(200).send(`User params:${name}:${pass} `)
		// res.send(`PARAMS = ${name} : ${pass} -> ${newUserID}`)
		// client.$close()
	})
})

var port = process.env.PORT || 3000;
app.listen(port, function () {
  console.log('myapp listening on port ' + port);
});

function nextID(client, sequence) {
	client.prepare(
		`select \"${sequence}\".nextval from dummy`,
		function(err, statement) {
			statement.exec([],
				function(err, results) {
					if (!err) {
						return results
					}
				})
		}) 
}