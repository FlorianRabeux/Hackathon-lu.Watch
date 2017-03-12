var express = require('express');
var app = express();

var xsenv = require('sap-xsenv');
var services = xsenv.getServices({ hana:'lu.watch-hdi-container' });

var hdbext = require('sap-hdbext');

// var cds = require('sap-cds')
// cds.$importEntities([	
// 	{ $entity: "be.nrb::LuWatch.User" } ], main )
 

function main(error, entities) {
	if(error) {
		console(error)
	} else {
		 var oUser = [entities[ "be.nrb::LuWatch.User" ] ]
	}
}

// var conn = $.db.getConnection()
// var cds = $.require("sap-cds").xsjs(conn)


app.use('/', hdbext.middleware(services.hana));

app.get('/', function (req, res, next) {
	req.db.exec('SELECT CURRENT_UTCTIMESTAMP FROM DUMMY', function (err, rows) {
		if (err) { return next(err); }
		res.send('Current HANA time (UTC): ' + rows[0].CURRENT_UTCTIMESTAMP);
  });
});


app.get('/user', function(req, res, next){
	var cds = require('sap-cds')
	cds.$getTransaction(req.db, function(err, tx){
		tx
	})

}


app.get('/user', function(req, res, next){
	cds.$getTransaction(req.db, function(error, tx){
		tx.$get(oUser, {id: 1}, function(error, user){
			res.send(`Username: ${ user.name }`)
		})
	})
	// cds.$getEntities(["be.nrb::LuWatch.User"], function(err, entities){
	// 	var eUser = entities[ "be.nrb::LuWatch.User" ]
	// })
})

var port = process.env.PORT || 3000;
app.listen(port, function () {
  console.log('myapp listening on port ' + port);
});