var url = contextRoot + "books/random"

var http = new XMLHttpRequest()

http.onreadystatechange = function() {
    if (this.readyState != 4 || this.status != 200) {
        return
    }
    
    response = JSON.parse(this.responseText)
    document.getElementById("title").innerHTML = response.title
    document.getElementById("author").innerHTML = response.author
    document.getElementById("pages").innerHTML = response.pages

}

function getRandomBook() {
    http.open("GET", url)
    http.send()
}