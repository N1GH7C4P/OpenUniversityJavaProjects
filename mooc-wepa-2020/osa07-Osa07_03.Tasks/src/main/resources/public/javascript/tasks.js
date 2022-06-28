var url = contextRoot + "/tasks"

var http = new XMLHttpRequest()

http.onreadystatechange = function() {
    if (this.readyState != 4 || this.status != 200) {
        return
    }
    document.getElementById("received").innerHTML = this.responseText
}

function Post() {
    var data = {
        name: document.getElementById("tekstikentta").value
    }
    http.open("POST", url)
    http.send(JSON.stringify(data))
}

function List() {
    http.open("GET", url)
    http.send()
    
}