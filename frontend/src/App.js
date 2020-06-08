import React,{useState, useEffect} from 'react';

export default function App(){
  const [areas, setAreas] = useState([]);

  useEffect(() => {
    fetchData();
  })

  async function fetchData(){
    const response = await fetch('http://localhost:8080/area-comum/v1/area')
    const data = await response.json()
    setAreas(data)
  }

  async function excluir(id) {
    const requestOptions = {
      method: 'DELETE'
    };
    const response = await fetch(`http://localhost:8080/area-comum/v1/area/${id}`, requestOptions)
    fetchData();
  }


  return (
    <>
    <table>
      <thead>
      <tr>
        <th>Endereço</th>
        <th>Descricao</th>
        <th>Proprietário</th>
        <th colSpan="2">Ações</th>
      </tr>
      </thead>
      <tbody>
      { 
      areas.map(area => (
      <tr key={area.id}>
      <td>{area.endereco}</td>
      <td>{area.descricao}</td>
      <td>{area.proprietario}</td>
      <td><button>Editar</button></td>
      <td><button onClick={() => excluir(area.id) }>Excluir</button></td>
      </tr>
      ))}
      </tbody>
    </table>
    <button>Novo</button>
    </>
  );
};
