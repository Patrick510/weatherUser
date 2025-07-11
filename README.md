# 🌤️ Weather User API

API REST para gerenciamento de usuários e seus históricos de consultas meteorológicas.

🚀 Deploy em produção:  
🔗 **[https://weatheruser-production.up.railway.app](https://weatheruser-production.up.railway.app)**

---

## 🧩 Funcionalidades

- Criar, listar, editar e deletar usuários
- Autenticar usuários (login)
- Registrar e listar históricos de busca meteorológica por usuário

---

## 📮 Endpoints

### 🔐 Autenticação

**Login do usuário**

```
POST /users/login
```

**Body (JSON):**

```json
{
  "name": "usuario",
  "password": "senha"
}
```

**Retorno (200 OK):**

```json
{
  "id": 1,
  "name": "usuario"
}
```

---

### 👤 Usuários

**Criar novo usuário**

```
POST /users
```

**Body:**

```json
{
  "name": "usuario",
  "password": "senha"
}
```

**Listar todos os usuários**

```
GET /users
```

**Buscar usuário por ID**

```
GET /users/{id}
```

**Atualizar usuário**

```
PUT /users/{id}
```

**Body:**

```json
{
  "name": "novo_nome",
  "password": "nova_senha"
}
```

**Deletar usuário**

```
DELETE /users/{id}
```

---

### 🌍 Histórico de buscas

**Salvar novo histórico**

```
POST /users/history/{userId}
```

**Body:**

```json
{
  "city": "Curitiba",
  "country": "BR",
  "weatherDescription": "Nublado",
  "weatherIcon": "03d",
  "temperature": 22.5,
  "windSpeed": 3.4,
  "lon": -49.27,
  "lat": -25.43
}
```

**Listar histórico de um usuário**

```
GET /users/history/{userId}
```

---

## 🛠 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 / MySQL
- Maven
- Railway (Deploy em produção)

---

## ⚠️ Observações

- Esta API **não possui autenticação com token ou criptografia de senha**, pois se trata de um protótipo.
- Para uso real, recomenda-se implementar autenticação com JWT e hashing de senhas (ex: BCrypt).

---

## 🧪 Exemplo de teste com `fetch` no frontend

```js
const login = async () => {
  const res = await fetch(
    "https://weatheruser-production.up.railway.app/users/login",
    {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name: "patrick", password: "123456" }),
    }
  );

  const data = await res.json();
  localStorage.setItem("userId", data.id);
};
```

---

## ✨ Autor

Desenvolvido por **Sr. Patrick** 🚀
