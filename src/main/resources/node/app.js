const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => res.send('Hello Javascript World!'))
app.get('/health', (req, res) => res.json({'res':'ok'}))
app.get('/javaresponse', (req, res)=> res.send(someJavaMethod()))

app.listen(port, () => console.log(`Example app listening on port ${port}!`))
