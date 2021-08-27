users : 
    uuid
    name
    email
    password
    role
    created
    updated

customers :
    uuid 
    name
    email
    password
    created
    updated

supports :
    uuid
    name
    email
    created
    updated

messages :
    uuid
    parentUuid (сообщение, которое было перед ним, если его не было, то null)
    payload
    from (клиент или тех поддержка)
    to (клиент или тех поддержка)
    created
    updated