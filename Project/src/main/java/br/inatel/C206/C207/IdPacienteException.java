package br.inatel.C206.C207;

public class IdPacienteException extends Exception{

    public IdPacienteException(int id){
        System.out.println("Voce entrou com o código do paciente menor ou igual a 0.");
    }

}
