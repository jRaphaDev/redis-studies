const redis = require('redis');
const client = redis.createClient();

const KEY = 'user'

client.on('connect', () => {
    console.log('Redis Client connected')
});

function create(user) {
    return client.set(KEY, user, redis.print);
}

function findAll() {
    client.get(KEY, (error, result) => result);
}

module.exports = { create, findAll }