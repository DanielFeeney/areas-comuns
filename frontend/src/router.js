import React from "react";
import List from "./components/list";
import ListReservaPendente from "./components/listReservaPendente";
import ListReservaAprovada from "./components/listReservaAprovada";
import ListReservaRejeitada from "./components/listReservaRejeitada";
import ListReservaCancelada from "./components/listReservaCancelada";
import Create from "./components/create";
import Reserva from "./components/reserva";
const routes = {
  "/listAreaComum": () => <List />,
  "/listReservaPendente": () => <ListReservaPendente />,
  "/listReservaAprovada": () => <ListReservaAprovada />,
  "/listReservaRejeitada": () => <ListReservaRejeitada />,
  "/listReservaCancelada": () => <ListReservaCancelada />,
  "/create": () => <Create />,
  "/reserva/:id": ({id}) => <Reserva areaId={id} />
};

export default routes;