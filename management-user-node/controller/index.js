const express = require('express');
const controller = require('./controller');
const bodyParser = require('body-parser');
const app = express();
app.use(bodyParser.json())
const router = express.Router();

router.use(bodyParser.json());

router.get('/create', controller.create);
router.get('/findall', controller.findAll);

module.exports = router;