fetch("")
    .then(Response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
 
    })
    .then(data => console.log(data));
    .then(error => console.error(error));