<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header justify-content-center">
        <h5 class="modal-title" id="loginModalTitle">Login</h5>
      </div>
      <div class="modal-body">
        <form action="fazer_login" method="get" class="form-inline m-0">
          <div class="form-row mx-auto">
            <div class="col">
              <div class="form-group">
                <label for="usuario" class="bmd-label-floating">Usuário</label>
                <input type="text" name="usuario" class="form-control" id="usuario">
              </div>
            </div>
            <div class="col">
              <div class="form-group">
                <label for="senha" class="bmd-label-floating">Senha</label>
                <input type="password" name="senha" class="form-control" id="senha">
              </div>
            </div>
          </div>
          <div class="form-row w-100">
            <div class="col">
              <span class="form-group mt-4">
                <button type="submit" class="btn btn-success active rounded-0 mx-auto">Entrar</button>
              </span>
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
      </div>
    </div>
  </div>
</div>