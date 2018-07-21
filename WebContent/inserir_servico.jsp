<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="AdicionaServico">
		<fieldset>
			 <legend>Cadastro</legend>
			 <table id="tabela_servico">
			
				
				<tr>
					<td><label for="descricao">descricao:</label></td>
					<td><input type="text" name="descricao"></td>
					
				</tr>
				
					<tr>
					<td><label for="servico">Caracteristicas do servico:</label></td>
					<td><input type="text" name="caracteristicas"></td>
					
				</tr>
				
					<tr>
					<td><label for="cobranca">Formas de cobranca:</label></td>
					<td><input type="text"  name="cobranca"></td>
					
				</tr>
				
					<tr>
					<td><label for="preco">Preco:</label></td>
					<td><input type="text"  name="preco"></td>
				</tr>
				
			</table>
		</fieldset>

		<input type="submit" value="Cadastrar">
		
		<INPUT  TYPE="button" VALUE ="Voltar" onClick="history.go(-1)"/>

	</form>
</body>
</html>