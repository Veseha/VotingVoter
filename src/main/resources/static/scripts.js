


function refreshdd(){
    // console.log(employeesList);
    var dropdown = document.getElementById('selecting-ex');
    dropdown.className = 'form-select';
    removeOptions(dropdown);

    for (var i = 0; i < employeesList.length; i++) {
        var option = document.createElement('option');
        option.value = employeesList[i].id;
        option.text = employeesList[i].name;
        dropdown.appendChild(option);
    }
}

function removeOptions(selectElement) {
    var i, L = selectElement.options.length - 1;
    for(i = L; i >= 0; i--) {
        selectElement.remove(i);
    }
}

function addField(id_exec = -1, name_exec = -1, comment_exec = "") {
    counter++;


    var container = document.getElementById('fieldsContainer');
    var field = document.createElement('div');
    field.className = 'field row g-3 align-items-center';

    var div_dd = document.createElement('div');
    div_dd.className = 'col-auto';
    var div_input = document.createElement('div');
    div_input.className = 'col-auto';

    var dropdown = document.createElement('select');
    dropdown.className = 'form-control';
    dropdown.name = 'field';

    var comment = document.createElement('input');
    comment.className = 'form-control';
    comment.type = 'text';
    comment.name = 'comment';


    var option = document.createElement('option');
    if(id_exec !== -1){
        option.value = id_exec;
        option.text = name_exec;
        comment.value = comment_exec;
        // option.id = 'currunt_choose';

    }
    else{
        var e = document.getElementById("selecting-ex");
        option.value = e.options[e.selectedIndex].value;
        option.text = e.options[e.selectedIndex].text;
        comment.value = 'Executor';
    }
    dropdown.appendChild(option);



    var removeButton = document.createElement('button');
    removeButton.className = 'btn btn-outline-secondary col-auto';
    removeButton.type = 'button';
    removeButton.innerHTML = 'Delete';
    removeButton.onclick = function() {
        removeField(this);
    };

    div_dd.appendChild(dropdown);
    field.appendChild(div_dd);

    div_input.appendChild(comment);
    field.appendChild(div_input);

    field.appendChild(removeButton);

    container.insertBefore(field, container.firstChild);

    for (var j = 0; j < employeesList.length; j++) {
        console.log(employeesList[j].id + " " + option.value);
        if(employeesList[j].id.toString() === option.value.toString()){
            employeesList.splice(j, 1);
            // console.log("splice " + j);
            // console.log(employeesList);
        }
    }

    refreshdd();
}

function removeField(button) {
    var field = button.parentNode;
    field.parentNode.removeChild(field);
    for (var i = 0; i < employeesList_back.length; i++) {
        if(employeesList_back[i].id.toString() === field.children[0].children[0].children[0].value.toString()){
            employeesList.push(employeesList_back[i]);
            break;
        }
    }
    refreshdd();
}

function moveSelectedNEs(sourceId, targetId) {
    var sourceSelect = document.getElementById(sourceId);
    var targetSelect = document.getElementById(targetId);
    var selectedOptions = [].slice.call(sourceSelect.selectedOptions);
    selectedOptions.forEach(function (option) {
        targetSelect.appendChild(option);
    });
}

function moveAllNEs(sourceId, targetId) {
    var select1 = document.getElementById(sourceId);
    var select2 = document.getElementById(targetId);
    // var options = [].slice.call(sourceSelect.options);
    // options.forEach(function (option) {
    //   targetSelect.appendChild(option);
    // });

    for (var i = 0; i < select1.options.length; i++) {
        var option = select1.options[i];

        // Clone the option and append it to select2
        select2.appendChild(option.cloneNode(true));
    }

    // Clear all options from select1
    select1.innerHTML = '';
}

function selectAll()
{
    selectBox = document.getElementById("selectedNEs");

    for (var i = 0; i < selectBox.options.length; i++)
    {
        selectBox.options[i].selected = true;
    }
}

function goBack() {
    window.history.back();
}