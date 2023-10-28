#stage 1
FROM node:12.14.1-stretch as node
WORKDIR /app
COPY . .
RUN npm install --f
RUN npm run build --prod
#stage 2
FROM nginx:alpine
COPY --from=node /app/dist/crudtuto-Front /usr/share/nginx/html