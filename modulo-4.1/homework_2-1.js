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
            "data": new Date()
        },
        {
            "idPostagem":2,
            "idUsuario":4,
            "tipoPostagem":"PROGRAMAS DE FORMAÇÃO",
            "titulo":"Decola Dev",
            "descricao":"Última chamada para se tornar Desenvolvedor FullStack !!!",
            "foto":"http://foto.decola",
            "curtidas":999,
            "data": new Date()
        }
    ]
)

db.devland.insertMany(
    [
        {
            "idPostagem":1,
            "idUsuario":1,
            "tipoPostagem":"VAGAS",
            "titulo":"Oportunidade de trabalho remoto - EUA",
            "descricao":"Vaga 100% remota, muitos benefícios e salário acima do mercado. Ganhe em Dolar!!",
            "foto":"http://vaga.remoto",
            "curtidas":99,
            "data": new Date()
        },
        {
            "idPostagem":2,
            "idUsuario":4,
            "tipoPostagem":"PROGRAMAS DE FORMAÇÃO",
            "titulo":"Foguete Dev Ultimate",
            "descricao":"Venha para a carreira que mais cresce no Brasil !!!",
            "foto":"http://foto.decola",
            "curtidas":999,
            "data": new Date()
        }
    ]
)

db.devland.find().pretty()

db.devland.find({ nome:"João"}).pretty()

db.devland.find({
    tipoPostagem: "VAGAS"
})

db.devland.find({
    tipoPostagem: "PROGRAMAS DE FORMAÇÃO"
})

db.devland.find({
    "nome": /^Jo/ 
})

db.devland.find({
  nome: {
    $regex: "mi*",
    $options: "i"
  }
})

db.devland.updateOne(
   { nome: "Joao" },
   {
     $set: { "nome": "João Teste", cpfCnpj: "66928892862" }           
   }
)

db.devland.updateOne(
   { nome: "Microsoft" },
   {
     $set: { "nome": "Microsoft Teste", cpfCnpj: "12345678912345" }           
   }
)

db.devland.find({
    curtidas: { $gte: 9 } 
}).sort("titulo")

db.devland.find({
    curtidas: { $gte: 100 } 
}).sort("titulo")

db.devland.find({ }).sort( { curtidas : 1} )

db.devland.find({ }).sort( { cpfCnpj : 1, nome : -1} )

db.devland.deleteMany({ _id : { $lt : 2} })

db.devland.deleteMany({ _id : { $gt : 1} })

db.devland.find({ tipoPostagem: "VAGAS"}, 
{
 titulo_descricao: { $concat: [ "$titulo", " - ", { $convert: { input: "$descricao", to: "string" }}] },
 data: { $dateToString: { date: "$data", format: "%d/%m/%Y" } }
})

db.devland.find({ tipoPostagem: "PROGRAMAS DE FORMAÇÃO"}, 
{
 titulo_descricao: { $concat: [ "$titulo", " - ", { $convert: { input: "$descricao", to: "string" }}] },
 data: { $dateToString: { date: "$data", format: "%d/%m/%Y" } }
})

db.devland.aggregate( [
   { $match: { tipoPostagem: "VAGAS" } },
   { $group: { _id: "$tipoPostagem", sumQuantity: {$sum: "$curtidas" }} }
] )

db.devland.aggregate( [
   { $match: { tipoPostagem: "PROGRAMAS DE FORMAÇÃO" } },
   { $group: { _id: "$tipoPostagem", sumQuantity: {$sum: "$curtidas" }} }
] )
