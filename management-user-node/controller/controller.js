const repository = require('../repository/userRepository');
const express = require('express');
const redis = require('redis');
const client = redis.createClient();
const app = express();
const bodyParser = require('body-parser');
app.use(bodyParser.json())
const KEY = 'user'

function create(req, res) {

    repository.create([{"id": 1, "name":"raphael"}, {"id": 2, "name":"freitas"}])
        .then(result => {
            return res.status(200).json(result);
        })
        .catch(error => {
            return res.status(500).send(error)
        });

}

function findOne(req, res) {

    repository.findAll()
        .then(result => {
            return res.status(200).send(result);
        })
        .catch(error => {
            return res.status(500).send(error);
        });
}

function remove(req, res) {

}

module.exports = { create, findOne, remove };