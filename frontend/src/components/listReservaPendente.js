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
import { FormControlLabel, RadioGroup, Radio, Button } from '@material-ui/core';

export default function ListReserva(){
  const [areas, setAreas] = useState([]);

  useEffect(() => {
    fetchDataPendetente();
  }, []);


  async function fetchDataPendetente(){
    const response = await fetch('http://localhost:8080/area-comum/v1/reserva/pendentes')
    const data = await response.json()
    setAreas(data)
  }

  const aprovar = async (id) => {
    const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
    };
    const response = await fetch(`http://localhost:8080/area-comum/v1/reserva/aprovar/${id}`, requestOptions);
    const data = await response.json();
    await fetchDataPendetente()
  }

  const rejeitar = async (id) => {
    const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
    };
    const response = await fetch(`http://localhost:8080/area-comum/v1/reserva/rejeitar/${id}`, requestOptions);
    const data = await response.json();
    await fetchDataPendetente()
  }


  const useStyles = makeStyles({
    table: {
        minWidth: 650,
      },
  });

  const classes = useStyles();

  return (
    <>
    
    <h1>Pendentes</h1>
    <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Endereço</TableCell>
            <TableCell align="right">Descrição</TableCell>
            <TableCell align="right">Proprietário</TableCell>
            <TableCell align="right">Data da reserva</TableCell>
            <TableCell align="center" colSpan={2}>Ação</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {areas.map((area) => (
            <TableRow key={area.id}>
              <TableCell>{area.endereco}</TableCell>
              <TableCell align="right">{area.descricao}</TableCell>
              <TableCell align="right">{area.proprietario}</TableCell>
              <TableCell align="right">{area.dataReserva}</TableCell>
              <TableCell align="right"><Button variant="contained" color="primary" onClick={() => aprovar(area.id)}>Aprovar</Button></TableCell>
              <TableCell align="right"><Button variant="contained" color="secondary" onClick={() => rejeitar(area.id)}>Rejeitar</Button></TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
          
    </>
  );
};
