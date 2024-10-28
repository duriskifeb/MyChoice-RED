// const JsonNames = ["Muhammad", "Rizky", "Febriyanto",];
const jsonPerson = { 
    "name": "Muhammadd",
    "age": "20",
    "isEmpleyed": true,
    "Hobbies": ["Mancing perkoro", "nyolong sandal", "gelut"]
};
const jsonPeoples = [{"name": "pop", "age": "20", "isEmpleyed": true}]
                     [{"name": "pop", "age": "20", "isEmpleyed": true}]
                     [{"name": "pop", "age": "20", "isEmpleyed": true}]
                     [{"name": "pop", "age": "20", "isEmpleyed": true}]
                     [{"name": "pop", "age": "20", "isEmpleyed": true}]
//this String 
const jsonString = JSON.stringify(person);
//this parse
const parseData = JSON.parse(jsonPerson);

console.log(parseData);