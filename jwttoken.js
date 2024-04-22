const express = require("express");
const jwt = require('jsonwebtoken');
const app = express();
const jwtpassword = "123456789";
app.use(express.json());

const ALL_USERS = [
    {
        username: "Saksham Sharma",
        email: "saksham@example.com",
        password: "12345"
    },
    {
        username: "Ayush Sharma",
        email: "ayush@example.com",
        password: "67890"
    },
    {
        username: "Jhon sina",
        email: "jhonsina@gmail.com",
        password: "abcdefg"
    }
];

function Verification(email, password) {
    for(let user of ALL_USERS) {
        if(user.email === email  && user.password == password){
            return true;
        }
    }
    return false;
}
app.post('/signup', (req, res)=>{
    const username = req.body.username;
    const email = req.body.email;
    const password = req.body.password;

    if(!Verification(email, password)) {
        return res.status(403).json({
            message: "User does not exist in memmory"
        });
    }

    var token = jwt.sign({email: email}, jwtpassword);
    res.json({
        token
    })
});

app.get("/user", function(req, res) {
    let token = req.headers.authorization;
    let decode = jwt.verify(token, jwtpassword);
    res.json({
        users: ALL_USERS.filter((value)=>{
            if(value.email === decode.email) {
                return true;
            }else {
                return false;
            }
        })
    })
    
});

app.listen(3000, ()=>{
    console.log("Listen to port 3000");
});