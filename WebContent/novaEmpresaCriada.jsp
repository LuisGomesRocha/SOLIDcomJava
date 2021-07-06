<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="container">
  <h2>
    Create a new blog post
  </h2>

  <form method="POST" action="/create">

    <div>
      <label for="aluno">Aluno</label>
      <input type="text" name="aluno" id="aluno" size="40" value="${fn:escapeXml(blog.title)}" class="form-control" />
    </div>

    <div>
      <label for="turma">Turma</label>
      <input type="text" name="turma" id="turma" size="40" value="${fn:escapeXml(blog.author)}" class="form-control" />
    </div>

    <div>
      <label for="resposta">Resposta</label>
      <textarea name="resposta" id="resposta" rows="10" cols="50" class="form-control">${fn:escapeXml(blog.content)}</textarea>
    </div>

    <button type="submit">Save</button>
  </form>
</div>