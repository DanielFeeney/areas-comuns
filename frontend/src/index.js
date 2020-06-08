import React from "react";
import ReactDOM from "react-dom";
import { useRoutes, A } from "hookrouter";
import { makeStyles } from '@material-ui/core/styles';
import ListSubheader from '@material-ui/core/ListSubheader';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import routes from "./router";

function App() {
  const useStyles = makeStyles((theme) => ({
    root: {
      width: '100%',
      color: 'white',
      backgroundColor: 'gray',
      display: 'flex',
      flexDirection: 'row',
    },
    line: {
      float: 'left',
    }
  }));
  const classes = useStyles();
  const [open, setOpen] = React.useState(true);

  function ListItemLink(props) {
    return <ListItem button component="a" {...props} />;
  }


  const routeResult = useRoutes(routes);
  return (
    <div className="App">
      <List
      component="nav"
      aria-labelledby="nested-list-subheader"
      
      className={classes.root}
      >
      <ListItemLink href="/listAreaComum">
        <ListItemText primary="Áreas Comuns" />
      </ListItemLink>
      <ListItemLink href="/listReservaPendente">
        <ListItemText primary="Reservas Pendentes" />
      </ListItemLink>
      <ListItemLink href="/listReservaAprovada">
        <ListItemText primary="Reservas Aprovadas" />
      </ListItemLink>
      <ListItemLink href="/listReservaRejeitada">
        <ListItemText primary="Reservas Rejeitadas" />
      </ListItemLink>
      <ListItemLink href="/listReservaCancelada">
        <ListItemText primary="Reservas Canceladas" />
      </ListItemLink>
    </List>
      
      {routeResult}
    </div>
  );
}

const rootElement = document.getElementById("root");
ReactDOM.render(<App />, rootElement);