const mongoose = require("mongoose");
const express = require("express");

mongoose.connect("mongodb+srv://saksham:zGgbVgbkXK7QP56a@cluster0.dpkgzqy.mongodb.net/");

const User = mongoose.model("Users", {name: String, email: String, password: String});

const app = express();

app.use(express.json());

app.post("/signup", async function(req, res){
    const name = req.body.name;
    const email = req.body.email;
    const password = req.body.password;
    
    const existed = await User.findOne({email: email});

    if(existed) {
        return res.status(409).send("User already exists.");
    }

    const user = new User({
        name : name,
        email : email,
        password : password
    });
    user.save()
    res.json({
        msg: "Data Successfully Save"
    });
});

app.listen(3000, () => {
    console.log("Listen to port number 3000");
})