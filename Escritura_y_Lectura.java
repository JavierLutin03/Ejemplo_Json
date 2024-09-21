import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EmployeeJsonExample {

    // Método para escribir una lista de empleados en un archivo JSON
    public static void writeEmployeeJson(String filePath) {
        // Crear un arreglo de empleados
        JSONArray employeeList = new JSONArray();

        // Crear el primer empleado
        JSONObject employee1 = new JSONObject();
        employee1.put("nombre", "Carlos");
        employee1.put("edad", 35);
        employee1.put("departamento", "Recursos Humanos");

        // Crear el segundo empleado
        JSONObject employee2 = new JSONObject();
        employee2.put("nombre", "María");
        employee2.put("edad", 29);
        employee2.put("departamento", "Finanzas");

        // Crear el tercer empleado
        JSONObject employee3 = new JSONObject();
        employee3.put("nombre", "Ana");
        employee3.put("edad", 40);
        employee3.put("departamento", "IT");

        // Añadir los empleados al arreglo
        employeeList.put(employee1);
        employeeList.put(employee2);
        employeeList.put(employee3);

        // Crear un objeto JSON que contiene la lista de empleados
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("empleados", employeeList);

        // Escribir el archivo JSON
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonObject.toString(4)); // Escribir el JSON con indentación
            file.flush();
            System.out.println("Archivo JSON con lista de empleados escrito correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer la lista de empleados desde un archivo JSON
    public static void readEmployeeJson(String filePath) {
        try {
            // Leer el archivo JSON como texto
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Convertir el texto a un objeto JSON
            JSONObject jsonObject = new JSONObject(content);

            // Obtener la lista de empleados
            JSONArray employeeList = jsonObject.getJSONArray("empleados");

            // Recorrer la lista de empleados y mostrar la información
            System.out.println("Lista de empleados:");
            for (int i = 0; i < employeeList.length(); i++) {
                JSONObject employee = employeeList.getJSONObject(i);
                System.out.println("Nombre: " + employee.getString("nombre"));
                System.out.println("Edad: " + employee.getInt("edad"));
                System.out.println("Departamento: " + employee.getString("departamento"));
                System.out.println("----------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "empleados.json";

        // Escribir la lista de empleados en un archivo JSON
        writeEmployeeJson(filePath);

        // Leer la lista de empleados desde el archivo JSON
        readEmployeeJson(filePath);
    }
}
