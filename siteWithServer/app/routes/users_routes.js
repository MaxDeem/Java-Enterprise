bodyParser = require('body-parser').json();

module.exports = function(app, fs) {
    app.post('/info', (req, res) => {
        var url = require('url');
    var url_parts = url.parse(req.url, true);
    var query = url_parts.query;
    // console.log('Name ' + query['name']);
    // console.log('Surname ' + query['surname'])
    fs.appendFile('data.txt', query['name'] + ' ' + query['surname'] + '\r\n',
        function (err) {
            if (err) throw err;
            console.log('Saved!');
            res.send();
        });
});
    app.get('/users', function (request, response) {
        fs.readFile('data.txt', 'utf-8', function(err, data) {
            var lines = data.split('\n');

            var result = [];
            for (var i = 0; i < lines.length; i++) {
                result.push({'name' : lines[i].split(' ')[0],
                    'surname': lines[i].split(' ')[1]});
            }
            response.setHeader('Content-Type', 'application/json');
            response.send(JSON.stringify(result));
        });
    });
    app.post('reg_name', (request, respond) => {
        var url = require('url');

    })
};
