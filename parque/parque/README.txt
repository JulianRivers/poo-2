Noria

●	tiene una serie de vehículos
●	la noria se para cuando el vehículo le dice que hay pérdida de anclaje
●	noria es un tipo de atracción
●	para ponerse en marcha de nuevo verifica si ningún vehículo necesita reparación (o sea, que no hay ninguna operación de mantenimiento)


Vehículo

●	el vehículo pertenece a una noria
●	el vehículo se comunica con el CRA cuando detecta pérdida de anclaje
●	el vehículo puede estar dañado o funcionando
●	también el vehículo se comunica con la atracción para que se detenga
●	cuando el dispositivo le diga que ya se reparó el vehículo envía una señal a la noria para que vuelva a funcionar


Montaña rusa 

●	Tiene varios vagones. 
●	la montaña rusa se para cuando el vagón le dice que hay pérdida de anclaje
●	montaña rusa es un tipo de atracción
●	para ponerse en marcha de nuevo verifica si ningún vagón necesita reparación (o sea, que no hay ninguna operación de mantenimiento)

Vagón

●	el vagón pertenece a una montaña rusa
●	el vagón puede estar dañado o funcionando
●	el vagón se comunica con el CRA cuando detecta pérdida de anclaje 
●	también el vagón se comunica con la atracción para que se detenga
●	si se daña emite una señal de solicitud hasta que sea atendido

Operario

●	tiene un dispositivo
●	tiene un salario (la suma del salario base más los arreglos)
●	tiene un identificador
●	tiene una cantidad de averías reparadas (ninguna o más de una)
●	cobra un extra en función de las averías que repara al mes
●	calcular salario al final del mes
●	el operario recibe a través de su dispositivo la dirección y el número del vagón o vehículo a reparar
●	el operario le confirma al dispositivo que ya terminó el arreglo 


Dispositivo

●	los atributos de id y estado del operario
●	El dispositivo determina el estado del Operario y si está libre le manda la dirección de la atracción y el número de vehículo o vagón con posible avería. (inmediatamente ese dispositivo pasa a indicar que ese operario está ocupado)
●	el dispositivo debe llevar un conteo de las averías reparadas por el operario
●	una vez reparado debe informar a la atracción que puede funcionar
●	cuando el operario le confirme acabado el arreglo pasa el estado del operario a desocupado, además el dispositivo avisa a la CRA y al vehículo o vagón que ya está reparado

Atracción


●	la atracción tiene un atributo de conteo de vueltas, que permite detener la atracción

●	La atracción lleva un contador de averías pendientes

●	la atracción posee un vehículo o un vagón según sea el caso 

●	el sistema tendrá que ser capaz de contabilizar las personas que entran y salen de una atracción, con el fin de controlar dos cosas; ( dejo esto de abajo para saber para qué sirve el método)
○	en primer lugar, que no entren más personas de las que la atracción es capaz de sostener 
○	segundo lugar, que todo el mundo abandone la atracción una vez finalizado cada viaje.

●	El controlador de arranque y parada de la atracción puede recibir un mensaje indicando que la atracción está llena, para que inicie las labores de puesta en marcha de la atracción, (dejo esto de abajo para saber para qué sirve el método)

○	dicho mensaje puede provenir del torniquete de entrada que detecta cuando se produce la ocupación máxima de la atracción
○	o del propio operario que vigila la atracción siempre que aún no estando llena no hay más personas esperando para subir y él considera que es tiempo suficiente como para que se ponga en marcha.



torniquete(para revisar)

●	el torniquete debe tener 2 tipo uno de entrada y salida ( lo de abajo explica lo que debe hacer el método) 


○	el de entrada puede contar a las personas y determinar la ocupación máxima de la atracción

○	el torniquete de salida determina que el número de personas que han abandonado la atracción

●	se debe crear un método que realiza y guarde el conteo de personas tanto en entrada y salida ( explicación de los casos que deben tenerse en cuenta)

●	Si en el método las personas que entraron y salieron son las mismas , envía al torniquete de entrada un mensaje para que ponga a cero el contador de personas en la atracción, revise con la atracción si hay fallas o revisiones en espera 

●	En el caso en que este contador esté en 0 averías ( después de haber consultado con la atracción), el torniquete de entrada se pondrá verde para que entren los usuarios. si no entonces permanecerá en amarillo, indicando que esta esperando reparación.


CRA
●	tiene un arreglo de dispositivos donde busca los operarios

●	Cuando la CRA recibe un aviso de la atracción (ya se sabe cual es la atracción), en el que se le indica el vehículo o vagón con posible avería,busca inmediatamente un operario de mantenimiento disponible. 
○	En caso de no haber ninguno libre, informa a la atracción en cuestión(ya se sabe cual es la atracción) de que su petición no puede ser atendida, así dicha atracción emitirá una señal de solicitud de revisión hasta que su petición sea satisfecha.

●	Cuando la CRA encuentra un operario de mantenimiento libre le manda un mensaje indicando la calle del parque en la que se encuentra la atracción y el número de vehículo o vagón con posible avería




