use('vemserdbc');

db.devland.insertMany(
  [
    {
      "nome":"João",
      "email":"joao@teste.com",
      "areaAtuacao":"Java",
      "cpfCnpj":"66928892862",
      "foto":"https://foto.foto",
      "genero":"MASCULINO",
      "tipoUsuario":"DEV"
    },
    {
      "nome":"Microsoft",
      "email":"microsoft@teste.com",
      "areaAtuacao":"Desenvolvimento de Software",
      "cpfCnpj":"82867000000158",
      "foto":"https://foto.foto",
      "genero":"MASCULINO",
      "tipoUsuario":"EMPRESA"
    }
  ]
)

db.devland.find().pretty()

db.devland.find({ nome:"João"}).pretty()


