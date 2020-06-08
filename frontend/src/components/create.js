import React,{useState, useEffect} from 'react';
import { useForm, Controller  } from "react-hook-form";
import {  Checkbox, TextareaAutosize } from "@material-ui/core";
import Input from "@material-ui/core/Input";
import MaskedInput from 'react-text-mask';
import { Button } from '@material-ui/core';
import { navigate } from 'hookrouter';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import { makeStyles } from '@material-ui/core/styles';


export default function Create(){
    const { register, control, handleSubmit } = useForm();
    const onSubmit = data => salvar(data);

    async function salvar(body){
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(body)
        };
        const response = await fetch('http://localhost:8080/area-comum/v1/area', requestOptions);
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
    
    <h1>Criar área comum</h1>
    <section>
      <label>Endereço</label>
      <Input className={classes.max}  name="endereco" inputRef={register({ required: true })} />
    </section>
    <section>
      <label>Proprietário</label>
      <Input className={classes.half} name="proprietario" inputRef={register({ required: true, pattern: /^[A-Za-z]+$/i })} />
      
      <label>Telefone</label>
      <Input inputComponent={TextMaskCustom} name="telefone" inputRef={register({ required: true })} />
    </section>
    <section>
      <label>Descrição</label>
      <Input className={classes.max} name="descricao" inputRef={register({ required: true, maxLength: 200 })} />
    </section>
    <section>
    <Controller
        as={<Checkbox name="Churrasqueira"/>}
        name="churrasqueira"
        value="test"
        control={control}
        defaultValue={false}
      />
      <label>Churrasqueira</label>
      <Controller
        as={<Checkbox name="Piscina"/>}
        name="piscina"
        value="test"
        control={control}
        defaultValue={false}
      />
      <label>Piscina</label>
      <Controller
        as={<Checkbox name="Salao"/>}
        name="salao"
        value="test"
        control={control}
        defaultValue={false}
      />
      <label>Salão</label>
      </section>
      
      <br/>
      <Button variant="contained" color="primary" type="submit">Salvar</Button>
    </form>
    </CardContent>
    </Card>
  );
};
