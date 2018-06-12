const repository = require('../repository/userRepository');
const redis = require('redis');
const client = redis.createClient();

const KEY = 'user'

function create(req, res) {
    user = {"id": 2, "name": "Frei2tas"};
    client.set(KEY, user, redis.print);
    return res.status(200).json(user);
}

function findAll(req, res) {
    client.get(KEY, (error, result) => res.send(result));
}

function findOne(req, res) {

}

function remove(req, res) {

}

module.exports = { create, findAll, findOne, remove };