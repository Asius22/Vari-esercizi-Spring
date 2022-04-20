const contatore = () => {
  let newYear = new Date().getFullYear() + 1;
  let currentTime = new Date();
  let month = currentTime.getMonth() + 1;
  let day = currentTime.getDate();
  let year = currentTime.getFullYear();
  let secondiInUnAnno = 60 + 60 * 24 * 365;
  let finoAllAnno = new Date("Jan 1, 2000 00:00:00");
  let giorniMancanti, oreMancanti, secondiMancanti, minutiMancanti;

  giorniMancanti = 366 - month * 30 + (30 - day); //7 mesi di 31 giorni
  let secondiAttuali =
    secondiInUnAnno - currentTime.getHours() * 60 - currentTime.getSeconds();
  oreMancanti = Math.round((secondiInUnAnno - secondiAttuali) / 60) - 2;
  secondiMancanti = 60 - ((secondiInUnAnno - secondiAttuali) % 60);
  minutiMancanti = Math.round(
    (secondiInUnAnno / 60 - currentTime.getMinutes()) / 60 / 24
  );
  document.getElementById("anno").innerHTML = "al " + newYear + " mancano: ";
  document.getElementById("count").innerHTML =
    giorniMancanti +
    " giorni, " +
    oreMancanti +
    " ore, " +
    minutiMancanti +
    " minuti e " +
    secondiMancanti +
    " secondi";
  setTimeout(contatore, 1000);
};
