const redis = require('redis');
const client = redis.createClient();

const KEY = 'user'

client.on('connect', () => {
    console.log('Redis Client connected')
});

function create(user) {
    return new Promise((resolve, reject) => {
        client.set(KEY, JSON.stringify(user), redis.print);
        return resolve(user);
    })
}

function findAll() {
    return new Promise((resole, reject) => {
        client.get(KEY, (error, result) => {
            if (error)
                return reject(error);
            return resole(result);
        })
    })
}

module.exports = { create, findAll }