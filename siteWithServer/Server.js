const express = require('express');
const app = express();
const fs = require('fs');
require('./app/routes')(app, fs);
app.use(express.static('public'));
app.listen(443);
console.log("Server started at 443");