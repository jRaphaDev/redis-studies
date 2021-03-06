const express = require('express');
const controllers = require('./controller');

const app = express();

const port = 3001;

app.use(controllers);

app.listen(port, () => {
    console.log('api listening on port', port);
});