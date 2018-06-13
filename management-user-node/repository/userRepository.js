const redis = require('redis');
const client = redis.createClient();

const KEY = 'user'

client.on('connect', () => {
    console.log('Redis Client connected')
});

const create = (user) => {
    return new Promise((resolve, reject) => {
        client.set(KEY, JSON.stringify(user), redis.print);
        return resolve(user);
    })
}

const findOne = () => {
    return new Promise((resolve, reject) => {
        client.get(KEY, (error, result) => {

            if (error)
                return reject(error);

            return resolve(result);
        })
    })
}

const remove = () => {
    return new Promise((resolve, reject) => {
        client.del(KEY, (error, result) => {

            if (error)
                return reject(error)

            return resolve(result)
        })
    })
}

module.exports = { create, findOne, remove }