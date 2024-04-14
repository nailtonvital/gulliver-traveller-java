<%@ page import="com.gullivertraveller.gullivertraveller.model.Usuario" %>
<%@ page import="java.util.List" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Usuários</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"/>
</head>

<body>

<div class="container my-5">

    <% if (request.getAttribute("usuarios") != null) { %>
    <button type="button" class="btn btn-primary">Adicionar</button>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Nome</th>
            <th scope="col">Email</th>
            <th scope="col">Cidade</th>
            <th scope="col">Telefone</th>
            <th scope="col">Instagram</th>
        </tr>
        </thead>
        <tbody>
        <% List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            for (Usuario user : usuarios) { %>
        <tr>
            <td><%= user.getId_usuario() %></td>
            <td><% if (user.getNome() != null) { out.print(user.getNome()); } else { out.print("Nome não disponível"); } %></td>
            <td><% if (user.getEmail() != null) { out.print(user.getEmail()); } else { out.print("Email não disponível"); } %></td>
            <td><% if (user.getCidadeId() != null) { out.print(user.getCidadeId()); } else { out.print("Cidade não disponível"); } %></td>
            <td><% if (user.getTelefone() != null) { out.print(user.getTelefone()); } else { out.print("Telefone não disponível"); } %></td>
            <td><% if (user.getInstagram_usuario() != null) { out.print(user.getInstagram_usuario()); } else { out.print("Instagram não disponível"); } %></td>
            <td class="btn-group" role="group">
                <button type="button" class="btn btn-warning">Edit</button>
                <button type="button" class="btn btn-danger">Remove</button>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
