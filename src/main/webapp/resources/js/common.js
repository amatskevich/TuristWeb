function handleDrop(event, ui) {
    var droppedCar = ui.draggable;

    droppedCar.fadeOut('fast');
}

function mtsk() {
    alert('hellow world');
}

//function checkDouble(input) {
//    ch = input.value.replace(/[^\.\d,]/g, ''); //разрешаем вводить только числа и запятую
//    pos = ch.indexOf('.'); // проверяем, есть ли в строке запятая
//    if (pos != -1) { // если запятая есть
//        if ((ch.length - pos) > 4) { // проверяем, сколько знаков после запятой, если больше 1го то
//            ch = ch.slice(0, -1); // удаляем лишнее
//        }
//    }
//    input.value = ch; // приписываем в инпут новое значение
//}
//;

/**
 * Faces Validator
 */
//PrimeFaces.validator['numberValidator'] = {
//    pattern: /\S+@\S+/,
//    validate: function(element, value) {
//        //use element.data() to access validation metadata, in this case there is none.
//        if (!this.pattern.test(value)) {
//            throw {
//                summary: 'Validation Error',
//                detail: value + ' is not a valid email.'
//            }
//        }
//    }
//};