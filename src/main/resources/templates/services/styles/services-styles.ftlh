<style type="text/css">
    .btn-outline-info-custom {
        background-image: none;
        padding: 3rem 4.5rem;
        border-radius: 8px;
        color: #fff;
        background-color: #17a2b8;
        border-color: #17a2b8;
        font-size: 20pt;
    }

    .btn-outline-info-custom:hover {
        color: #17a2b8;
        background-color: transparent;
        border-color: #17a2b8;
    }

    .btn-outline-info-custom:focus, .btn-outline-info-custom.focus {
        box-shadow: 0 0 0 0.2rem rgba(23, 162, 184, 0.5);
    }


    .containerBS5 {
        --bs-gutter-x:1.5rem;
        --bs-gutter-y:0;
        width:100%;
        /*    padding-right:calc(var(--bs-gutter-x) * .5);
            padding-left:calc(var(--bs-gutter-x) * .5);*/
        margin-right:auto;
        margin-left:auto
    }

    @media (min-width:576px) {
        .containerBS5 {
            max-width:540px
        }
    }

    @media (min-width:768px) {
        .containerBS5 {
            max-width:720px
        }
    }

    @media (min-width:992px) {
        .containerBS5 {
            max-width:960px
        }
    }

    @media (min-width:1200px) {
        .containerBS5 {
            max-width:1140px
        }
    }

    @media (min-width:1400px) {
        .containerBS5 {
            max-width:1420px
        }
    }

    .rowBS5 {
        --bs-gutter-x:1.5rem;
        --bs-gutter-y:0;
        display:flex;
        flex-wrap:wrap;
        margin-top:calc(-1 * var(--bs-gutter-y));
        margin-right:calc(-.5 * var(--bs-gutter-x));
        margin-left:calc(-.5 * var(--bs-gutter-x))
    }

    .rowBS5>*{
        flex-shrink:0;
        width:100%;
        max-width:100%;
        padding-right:calc(var(--bs-gutter-x) * .5);
        padding-left:calc(var(--bs-gutter-x) * .5);
        margin-top:var(--bs-gutter-y)
    }

</style>