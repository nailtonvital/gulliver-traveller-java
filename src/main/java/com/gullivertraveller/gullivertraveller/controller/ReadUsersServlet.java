package com.gullivertraveller.gullivertraveller.controller;

import com.gullivertraveller.gullivertraveller.dao.DataSource;
import com.gullivertraveller.gullivertraveller.dao.UsuarioDAO;
import com.gullivertraveller.gullivertraveller.model.Usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/readUsers")
public class ReadUsersServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String pagina;
        try {
            DataSource ds = new DataSource();
            UsuarioDAO usuarioDAO = new UsuarioDAO(ds);

            // Supondo que a lista de usuários é obtida do método getUsuarios() em UsuarioDAO
            List<Usuario> usuarios = usuarioDAO.readAll();

            if (usuarios != null && !usuarios.isEmpty()) {
                req.setAttribute("usuarios", usuarios); // Adiciona a lista de usuários ao request
                pagina = "/readUsers.jsp";
            } else {
                req.setAttribute("ErroMSG", "Nenhum usuário encontrado");
                pagina = "/error.jsp";
            }
        } catch (Exception e) {
            req.setAttribute("ErroMSG", e.getMessage());
            pagina = "/error.jsp";
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(req, res);
    }
}


//package br.com.masters3.controllers;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import br.com.masters3.beans.Usuario;
//import br.com.masters3.dao.DataSource;
//import br.com.masters3.dao.UsuarioDAO;
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet{
//
//    public void doPost(HttpServletRequest request,
//                       HttpServletResponse response) {
//        String pagina="";
//        try {
//// crio a conexao com o banco
//            DataSource dataSource = new DataSource();
//// passo o DataSource para o DAO
//            UsuarioDAO usuarioDao =
//                    new UsuarioDAO(dataSource);
//// agora vamos criar um usuário para  recuperar os
//// dados do form via request
//            Usuario userLogin = new Usuario();
//            userLogin.setEmail(
//                    request.getParameter("email"));
//            userLogin.setSenha(
//                    request.getParameter("senha"));
//            Usuario user = usuarioDao.read(userLogin);
//            if (user != null) {
//// aqui um segredo importantíssimo manter o
////  usuário conectado!
//                request.getSession()
//                        .setAttribute("Usuario", user);
//                pagina = "/dados_usuario.jsp";
//            }
//            else {
//                request.setAttribute("ErroMSG",
//                        "Usuario nao encontrado");
//                pagina = "/erro.jsp";
//            }
//
//// só nos resta redirecionar para a página resultante
//            RequestDispatcher dispatcher =
//                    getServletContext()
//                            .getRequestDispatcher(pagina);
//            dispatcher.forward(request, response);
//        }
//        catch(Exception ex) {
//            System.out.println("ERRO on LOGINSERVLET "+
//                               ex.getMessage());
//        }
//    }
//}