import React,{useState, useEffect} from 'react';
import { useForm  } from "react-hook-form";
import {  Checkbox } from "@material-ui/core";
import Input from "@material-ui/core/Input";
import MaskedInput from 'react-text-mask';
import Grid from '@material-ui/core/Grid';
import DateFnsUtils from '@date-io/date-fns';
import { Button } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Divider from '@material-ui/core/Divider';
import { navigate } from 'hookrouter';
import {
  MuiPickersUtilsProvider,
  KeyboardTimePicker,
  KeyboardDatePicker,
} from '@material-ui/pickers';



export default function Reserva({areaId}){
    const [area, setArea] = useState( { id: null, descricao: '', proprietario: '', endereco: '', telefone: '', churrasqueira: false, piscina: false, salao: false });
    const { register, control, handleSubmit } = useForm();
    const onSubmit = data => salvar(data);
    const [selectedDate, setSelectedDate] = React.useState(new Date());

    const handleDateChange = (date) => {
      setSelectedDate(date);
    };

    useEffect(() => {
        fetchSingleData()
    }, []);

    async function fetchSingleData(){
        const response = await fetch(`http://localhost:8080/area-comum/v1/area/${areaId}`)
        const data = await response.json()
        setArea(data)
      }

    async function salvar(body){
        const requestOptions = {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(body)
        };
        const response = await fetch(`http://localhost:8080/area-comum/v1/reserva/${areaId}`, requestOptions);
        const data = await response.json();
        navigate('/listAreaComum',true)
    }

    function TextMaskCustom(props) {
        const { inputRef, ...other } = props;
      
        return (
          <MaskedInput
            {...other}
            ref={(ref) => {
              inputRef(ref ? ref.inputElement : null);
            }}
            mask={['(', /[1-9]/, /\d/, ')', /\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/]}
            placeholderChar={'\u2000'}
            showMask
          />
        );
    }

    const useStyles = makeStyles((theme) => ({
      max: {
        width: '100%',
      },
      half:{
        width: '50%',
      }

    }));
    const classes = useStyles();


  return (
    <Card>
      <CardContent>
    <form onSubmit={handleSubmit(onSubmit)}>
    <h1>Reservar</h1>
    <section>
      <label>Endereço</label>
      <Input className={classes.max} name="endereco" value={area.endereco} inputRef={register({ required: true })} />      
    </section>
    <section>
      <label>Proprietário</label>
      <Input className={classes.half} name="proprietario" value={area.proprietario} inputRef={register({ required: true, pattern: /^[A-Za-z]+$/i })} />
      <label>Telefone</label>
      <Input inputComponent={TextMaskCustom} value={area.telefone} name="telefone" inputRef={register({ required: true })} />
    </section>
    <section>
      <label>Descrição</label>
      <Input className={classes.max} name="descricao" value={area.descricao} defaultValue={area.descricao} inputRef={register({ required: true, maxLength: 200 })} />    
    </section>
    <section>
      <Checkbox name="churrasqueira" value={area.churrasqueira} checked={area.churrasqueira} inputRef={register()}/>
      <label>Churrasqueira</label>

      <Checkbox name="piscina" value={area.piscina} checked={area.piscina} inputRef={register()}/>
      <label>Piscina</label>

      <Checkbox name="salao" value={area.salao} checked={area.salao} inputRef={register()}/>
      <label>Salão</label></section>
      <Divider/>
      <MuiPickersUtilsProvider utils={DateFnsUtils}>
      <Grid container >
        <KeyboardDatePicker
          name="dataReserva"
          margin="normal"
          id="date-picker-dialog"
          label="Selecione a data"
          format="dd/MM/yyyy"
          value={selectedDate}
          onChange={handleDateChange}
          inputRef={register()}
          KeyboardButtonProps={{
            'aria-label': 'change date',
          }}
        />
      </Grid>
    </MuiPickersUtilsProvider>
    <Button variant="contained" color="primary" type="submit">Reservar</Button>
    </form>
    </CardContent>
    </Card>
  );
};