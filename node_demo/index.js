const http = require("http");

var server = http.createServer(function(req, res){
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/plain');
    res.end('Hello World\n');
})

var PORT = 5000;

server.listen(PORT, () => {
    console.log('Server running at http://localhost:5000/');
})