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

db.devland.insertMany(
    [
        {
            "idPostagem":1,
            "idUsuario":1,
            "tipoPostagem":"VAGAS",
            "titulo":"Oportunidade de trabalho remoto",
            "descricao":"Vaga 100% remota, muitos benefícios e salário acima do mercado.",
            "foto":"http://vaga.remoto",
            "curtidas":99,
            "data": new Date.now()
        },
        {
            "idPostagem":2,
            "idUsuario":4,
            "tipoPostagem":"PROGRAMAS DE FORMAÇÃO",
            "titulo":"Decola Dev",
            "descricao":"Última chamada para se tornar Desenvolvedor FullStack !!!",
            "foto":"http://foto.decola",
            "curtidas":999,
            "data": new Date.now()
        }
    ]
)

db.devland.find().pretty()

db.devland.find({ nome:"João"}).pretty()


