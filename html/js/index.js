const checkName = () => {
  let input = document.getElementById("nome");

  let regex = new RegExp("^(\\S[A-Za-z-À-ú\\s ]+)$");
  if (!regex.test(input.value)) {
    input.classList.add("error");
    return false;
  } else {
    input.classList.remove("error");
    return true;
  }
};

const checkMatricola = () => {
  let matInput = document.getElementById("matricola");
  let matricola = parseInt(matInput.value);

  if (isNaN(matricola) || matricola > 2000 || matricola < 1) {
    matInput.classList.add("error");
    return false;
  } else {
    matInput.classList.remove("error");
    return true;
  }
};

const checkValidate = () => {
  event.preventDefault();
  if (!checkMatricola() || !checkName()) {
    event.stopPropagation();
    alert("controlla il tuo input");
  }
};
