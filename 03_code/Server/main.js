const mysql = require('mysql');
const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const port = 3000;

app.set("port", port);
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

app.get('/', (req, res) => {
  res.send('Hello World!');
});

app.listen(port, () => {
    console.log('Server Runnning...');
});

const connection = mysql.createConnection({
    host: "Put your RDS endpoint here",
    user: "RDS user name",
    database: "example",
    password: "RDS user password",
    port: 3306
});

app.post('/user/write', (req, res) => {
    console.log(req.body);
    const userName = req.body.userName;
    const userId = req.body.userId;

    const sql = 'INSERT INTO Users (UserName, UserId) VALUES (?, ?)';
    const params = [userName, userId];

    connection.query(sql, params, (err, result) => {
        let resultCode = 404;
        let message = 'Error occured';

        if (err) {
            console.log(err);
        } else {
            resultCode = 200;
            message = 'Write Success';
            console.log(message);
        }

        res.json({
            'code': resultCode,
            'message': message
        });
    });
});

app.post('/user/read', (req, res) => {
    console.log(req.body);
    const userName = req.body.userName;
    const sql = 'select * from Users where UserName = ?';
    const params = [userName];

    connection.query(sql, params, (err, result) => {
        let resultCode = 404;
        let message = 'Error occured';
        let userId = -1;

        if (err) {
            console.log(err);
        } else {
            if (result.length === 0) {
                resultCode = 404;
                message = "User '" + userName + "' does not exist";
                userId = "0000-00000";
            } else {
                resultCode = 200;
                message = 'Read Success';
                userId = result[0].UserId;
            }
        }
        res.json({
            'code': resultCode,
            'message': message,
            'userId' : userId,
        });
    })
});