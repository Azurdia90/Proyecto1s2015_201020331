# importamos los paquetes necesarios
from flask import Flask
import Estructuras.Raiz_aeropuerto as raiz_aeropuertos
import Estructuras.Lista_aeropuerto as lista_aeropuetos
#utilizacion de flask
app = Flask(__name__)

#raices de las estructuras a utilizar
raiz_lista = None

#metodos que se utlilizaran para el manejo de la lista de aeropuertos
@app.route('/insertar_avion', methods=['POST'])
def insertar_avion(datos):
    lista = lista_aeropuetos(raiz_lista)

    return "exito"

@app.route('/mostrar_avion', methods=['GET'])
def mostrar_avion():
    if raiz_lista.get_first() == None:
        return "esta vacio"
    else:
        return "hay algo"

if __name__ == '__main__':
    raiz_lista = raiz_aeropuertos.Raiz_aeropuerto()
    app.run()

