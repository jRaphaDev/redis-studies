const express = require('express');
const controller = require('./controller');
const bodyParser = require('body-parser');
const router = express.Router();

router.use(bodyParser.json());

router.get('/create', controller.create);
router.get('/findOne', controller.findOne);
router.get('/delete', controller.remove)

module.exports = router;