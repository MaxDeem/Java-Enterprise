const express = require('express');
const app = express();
app.use(express.static('public'));
app.listen(443);
console.log("Server started at 443");