const infoRoutes = require('./users_routes');
module.exports = function(app, fs) {
    infoRoutes(app, fs);
};