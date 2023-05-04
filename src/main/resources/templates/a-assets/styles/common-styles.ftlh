<style type="text/css">
    body {
        padding-top: 3.5rem;
    }

    .colorWrapper {
        background-color: #c1e2e8;
    }

    .vl {
        border-left: 0.1px solid white;
    }

    .displayCustom {
        font-size: 4.5rem;
        line-height: 1.5;
    }

    .name-font {
        font-weight: 800;
        font-family: Montserrat, "Open Sans", Helvetica, Arial, sans-serif;
    }

    .body-font {
        font-weight: 200;
        font-family: Montserrat, "Open Sans", Helvetica, Arial, sans-serif;
    }

    .jumbotronCustom {
        padding: 2rem 1rem;
        margin-bottom: 2rem;
        background-color: #17a2b8;
        color: white;
    }

    @media (min-width: 576px) {
        .jumbotronCustom {
            padding: 4rem 2rem;
        }
    }

    .logoContainer{
        content: url("/assets/SOLUS SOLUTIONS.png");
        width: 220px;
        height: 220px;
    }

    .logoContainerCropped{
        content: url("/assets/logo-cropped.png");
        width: 200px;
        height: 200px;
    }

    .footerLogoContainer{
        content: url("/assets/SOLUS SOLUTIONS.png");
        width: 200px;
        height: 200px;
    }

    .footerLogoContainerCropped{
        content: url("/assets/logo-cropped.png");
        width: 100px;
        height: 100px;
    }

    .containerCustom {
        width: 592px;
        margin-left: 30%;
    }

    .containerCustom {
        width: 100%;
        padding-right: 15px;
        padding-left: 15px;
        margin-right: auto;
        margin-left: auto;
        display: flex;
        flex-direction: row;
    }

    @media (min-width: 576px) {
        .containerCustom {
            max-width: 540px;
        }
    }

    @media (min-width: 768px) {
        .containerCustom {
            max-width: 720px;
        }
    }

    @media (min-width: 992px) {
        .containerCustom {
            max-width: 960px;
        }
    }

    @media (min-width: 1200px) {
        .containerCustom {
            max-width: 1140px;
        }
    }

    .containerCustom {
        width: 592px;
        margin-left: 30%;
    }

    .containerCustom {
        width: 100%;
        padding-right: 15px;
        padding-left: 15px;
        margin-right: auto;
        margin-left: auto;
        display: flex;
        flex-direction: row;
    }

    @media (min-width: 576px) {
        .containerCustom {
            max-width: 540px;
        }
    }

    @media (min-width: 768px) {
        .containerCustom {
            max-width: 720px;
        }
    }

    @media (min-width: 992px) {
        .containerCustom {
            max-width: 960px;
        }
    }

    @media (min-width: 1200px) {
        .containerCustom {
            max-width: 1140px;
        }
    }

    .dangerCustom {
        color: #fff;
        background-color: #dc3545;
        border-color: #bd3e47;
    }

    .dangerCustom:hover {
        color: #fff;
        background-color: #bd3e47;
        border-color: #963239;
    }

    .dangerCustom:focus, .dangerCustom.focus {
        box-shadow: 0 0 0 0.2rem rgba(220, 53, 69, 0.5);
    }

    .dangerCustom.disabled, .dangerCustom:disabled {
        color: #fff;
        background-color: #bd3e47;
        border-color: #dc3545;
    }

    .dangerCustom:not(:disabled):not(.disabled):active, .dangerCustom:not(:disabled):not(.disabled).active,
    .show > .dangerCustom.dropdown-toggle {
        color: #fff;
        background-color: #b83740;
        border-color: #b21f2d;
    }

    .dangerCustom:not(:disabled):not(.disabled):active:focus, .dangerCustom:not(:disabled):not(.disabled).active:focus,
    .show > .dangerCustom.dropdown-toggle:focus {
        box-shadow: 0 0 0 0.2rem rgba(220, 53, 69, 0.5);
    }

    .dropdownItemCustom {
        display: block;
        width: 100%;
        padding: 0.25rem 1.5rem;
        clear: both;
        font-weight: 400;
        color: #212529;
        text-align: inherit;
        white-space: nowrap;
        background-color: transparent;
        border: 0;
    }

    .dropdownItemCustom:hover, .dropdownItemCustom:focus {
        color: #16181b;
        text-decoration: none;
        background-color: #f8f9fa;
    }

    .dropdownItemCustom.active, .dropdownItemCustom:active {
        text-decoration: none;
        background-color: #f0f1f2;
    }

    .dropdownItemCustom.disabled, .dropdownItemCustom:disabled {
        color: #6c757d;
        background-color: transparent;
    }

    @media screen and (min-width: 992px) {
        .dropdown:hover .dropdown-menu {
            display: block;
            margin-top: 0;
            transition: .1s;
        }
        .dropdown .dropdown-menu {
            display: none;
            transition: .1s;
        }
        .dropdown:hover .dropdown-toggle::after {
            border-top: 0;
            border-bottom: 0.3em solid;
        }
    }

    @media screen and (max-width: 991px) {
        .dropdown-toggle.show::after {
            border-top: 0;
            border-bottom: 0.3em solid;
            transition: .1s;
        }
    }

    .textBgCustom {
        color: white;
        background-color:#17a2b8;
    }

    .feature-icon {
        width: 4rem;
        height: 4rem;
        border-radius: .75rem;
    }

    .icon-link > .bi {
        margin-top: .125rem;
        margin-left: .125rem;
        fill: currentcolor;
        transition: transform .25s ease-in-out;
    }
    .icon-link:hover > .bi {
        transform: translate(.25rem);
    }

    .icon-square {
        width: 3rem;
        height: 3rem;
        border-radius: .75rem;
    }

    .text-shadow-1 { text-shadow: 0 .125rem .25rem rgba(0, 0, 0, .25); }
    .text-shadow-2 { text-shadow: 0 .25rem .5rem rgba(0, 0, 0, .25); }
    .text-shadow-3 { text-shadow: 0 .5rem 1.5rem rgba(0, 0, 0, .25); }

    .card-cover {
        background-repeat: no-repeat;
        background-position: center center;
        background-size: cover;
    }

    .feature-icon-small {
        width: 3rem;
        height: 3rem;
    }

    .containerCustomFlex {
        width: 592px;
        margin-left: 30%;
    }

    .containerCustomFlex {
        width: 100%;
        padding-right: 15px;
        padding-left: 15px;
        margin-right: auto;
        margin-left: auto;
        display: flex;
        flex-direction: row;
    }

    @media (min-width: 576px) {
        .containerCustomFlex {
            max-width: 540px;
        }
    }

    @media (min-width: 768px) {
        .containerCustomFlex {
            max-width: 720px;
        }
    }

    @media (min-width: 992px) {
        .containerCustomFlex {
            max-width: 960px;
        }
    }

    @media (min-width: 1200px) {
        .containerCustomFlex {
            max-width: 1140px;
        }
    }

    .text-muted-custom {
        color: #e8e8e8 !important;
    }

    .containerHeader {
        --bs-gutter-x:1.5rem;
        --bs-gutter-y:0;
        width:99%;
        /*    padding-right:calc(var(--bs-gutter-x) * .5);
            padding-left:calc(var(--bs-gutter-x) * .5);*/
        margin-right:auto;
        margin-left:auto
    }

    @media (min-width:576px) {
        .containerHeader {
            max-width:540px
        }
    }

    @media (min-width:768px) {
        .containerHeader {
            max-width:720px
        }
    }

    @media (min-width:992px) {
        .containerHeader {
            max-width:960px
        }
    }

    @media (min-width:1200px) {
        .containerHeader {
            max-width:1140px
        }
    }

    @media (min-width:1000px) {
        .containerHeader {
            max-width:1420px
        }
    }
</style>