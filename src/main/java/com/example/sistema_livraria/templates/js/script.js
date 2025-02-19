const formulario = document.getElementById("form");
const formLogin = document.getElementById("formLogin");
const formAtualizar = document.getElementById("formAtualizar")

const Inome = document.querySelector(".nome");
const Icpf = document.querySelector(".cpf");
const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");

function mascaraCPF(cpf){
    cpf=cpf.replace(/\D/g,"");
    cpf = cpf.substring(0, 11);           
    cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2");
    cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2");   
    cpf=cpf.replace(/(\d{3})(\d{1,2})$/,"$1-$2");
    return cpf;
};

Icpf.addEventListener('input', function () {
    Icpf.value = mascaraCPF(Icpf.value);
});

function validarCPF(cpf) {
    cpf = cpf.replace(/\D/g, '');

    if (cpf.length !== 11) {
        return false;
    }

    if (/^(\d)\1{10}$/.test(cpf)) {
        return false;
    }
    let soma = 0;
    for (let i = 0; i < 9; i++) {
        soma += parseInt(cpf.charAt(i)) * (10 - i);
    }
    let resto = (soma * 10) % 11;
    if (resto === 10 || resto === 11) {
        resto = 0;
    }
    if (resto !== parseInt(cpf.charAt(9))) {
        return false;
    }
    soma = 0;
    for (let i = 0; i < 10; i++) {
        soma += parseInt(cpf.charAt(i)) * (11 - i);
    }
    resto = (soma * 10) % 11;
    if (resto === 10 || resto === 11) {
        resto = 0;
    }
    if (resto !== parseInt(cpf.charAt(10))) {
        return false;
    }

    return true;
};

function validarEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
};

//FUNÇÃO DE CADASTRAR
function cadastrar () {
    const cpfFormatado = mascaraCPF(Icpf);
    if (!Inome.value || !Icpf.value || !Iemail.value || !Isenha.value) {
        alert("Por favor, preencha todos os campos.");
        return;
    }

    if (!validarCPF(Icpf.value)) {
        alert("CPF inválido!");
        return;
    }

    if (!validarEmail(Iemail.value)) {
        alert("E-mail inválido!");
        return;
    }

    fetch("http://localhost:8080/cliente/cadastro" , //endereço da api relacioado ao cadastro
    {
        headers: {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },
        method : "POST",
        body : JSON.stringify({
                nome: Inome.value,
                cpf: Icpf.value.replace(/\D/g, ''),
                email : Iemail.value,
                senha : Isenha.value
            })
    })
    .then(function (res) {
        if (!res.ok) {
            return res.json().then(err => { throw new Error(err.message || "Erro ao cadastrar."); });
        }
        return res.json();
    })
    .then(function (data) {
        alert("Cadastro realizado com sucesso!");
        window.location.href = "/login.html";
    })
    .catch(function (error) {
        console.error("Erro ao cadastrar:", error);
        alert(error.message);
    });
};

//FUNÇÃO DE LOGIN
function logar() {
    if (!Iemail.value || !Isenha.value) {
        alert("Por favor, preencha todos os campos.");
        return;
    }

    if (!validarEmail(Iemail.value)) {
        alert("E-mail inválido!");
        return;
    }

    if (!Isenha.value) {
        alert("Por favor, preencha a senha.");
        return;
    }

    fetch("http://localhost:8080/cliente/login", //endereço da api relacioado ao login
    {
        headers: {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },
        method : "POST",
        body : JSON.stringify({
            email : Iemail.value,
            senha : Isenha.value
        })
    })
    .then(function (data) {
        console.log("Login bem-sucedido:", data);
        alert("Login bem-sucedido!");
        // Exemplo de redirecionamento:
        window.location.href = "/index.html";
    })
    .catch(function (error) {
        console.error("Erro ao fazer login:", error);
        alert(error.message);
    });
};

// Função para atualizar os dados do usuário
function atualizarDados() {
    const novoNome = document.querySelector(".novoNome").value;
    const novoCpf = document.querySelector(".novoCpf").value;
    const novoEmail = document.querySelector(".novoEmail").value;
    const novaSenha = document.querySelector(".novaSenha").value;

    novoCpf.addEventListener('input', function () {
        novoCpf.value = mascaraCPF(novoCpf.value);
    });

    if (!novoNome || !novoCpf || !novoEmail || !novaSenha) {
        alert("Por favor, preencha todos os campos.");
        return;
    }

    if (!validarCPF(novoCpf)) {
        alert("CPF inválido!");
        return;
    }

    if (!validarEmail(novoEmail)) {
        alert("E-mail inválido!");
        return;
    }

    fetch("http://localhost:8080/cliente/atualizar",  //endereço da api relacioado ao login
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        method: "PUT",
        body: JSON.stringify({
            nome: novoNome,
            cpf: novoCpf.value.replace(/\D/g, ''),
            email: novoEmail,
            senha: novaSenha
        })
    })
    .then(function (res) {
        if (!res.ok) {
            return res.json().then(err => { throw new Error(err.message || "Erro ao atualizar os dados."); });
        }
        return res.json();
    })
    .then(function (data) {
        alert("Dados atualizados com sucesso!");
        window.location.href = "/perfil.html";
    })
    .catch(function (error) {
        console.error("Erro ao atualizar os dados:", error);
        alert(error.message);
    });
}

function limpar () {
    Inome.value = "";
    Icpf.value = "";
    Iemail.value = "";
    Isenha.value = "";
};

formulario.addEventListener ('submit', function (event) {
    event.preventDefault();
    cadastrar();
    limpar();
});

formLogin.addEventListener ('submit', function (event) {
    event.preventDefault();
    logar();
});

formAtualizar.addEventListener('submit', function (event) {
    event.preventDefault();
    atualizarDados();
});