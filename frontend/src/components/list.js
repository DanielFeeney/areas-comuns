import React,{useState, useEffect} from 'react';
import { A } from "hookrouter";
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import { Button } from '@material-ui/core';

export default function List(){
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
    console.log(response.json())
    fetchData();
  }
  const useStyles = makeStyles({
    table: {
      minWidth: 650,
    },
    a: {
      textDecoration: 'none'
    },
  });

  const classes = useStyles();

  return (
    <>
    <h1>Áreas Comuns</h1>
    <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Endereço</TableCell>
            <TableCell align="right">Descrição</TableCell>
            <TableCell align="right">Proprietário</TableCell>
            <TableCell align="right">Ação</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {areas.map((area) => (
            <TableRow key={area.id}>
              <TableCell>{area.endereco}</TableCell>
              <TableCell align="right">{area.descricao}</TableCell>
              <TableCell align="right">{area.proprietario}</TableCell>

              <TableCell align="right"><Button variant="contained" color="primary" href={`/reserva/${area.id}`} >Reservar</Button></TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    
    <Button variant="contained" color="primary" href="/create">Novo</Button>
    </>
  );
};
