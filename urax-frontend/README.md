# Frontend

## Preparations (Already done)
>The following tasks is just for reference and has already been done. The output has become modified and commit to the code-repository.
### Install angular
> This will install angular globally (_hence the `-g`_)

```
$ npm install -g @angular/cli
```
### Create project
This will create a new ng-prject project called Urax
```
ng new Urax --routing=true --style=css --strict=false
ng new Urax

# Change directory to the project in order to add ng-stuff...
cd Urax

ng g s services/uraxapiservice

ng g c components/product-add
ng g c components/product-details
ng g c components/product-list
ng g class models/product --type=model
```
